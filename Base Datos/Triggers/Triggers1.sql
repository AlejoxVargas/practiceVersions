CREATE TABLE leads (
	id INTEGER PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	phone TEXT NOT NULL,
	email TEXT NOT NULL,
	source TEXT NOT NULL
);

CREATE TABLE lead_logs (
	id INTEGER PRIMARY KEY,
	old_id int,
	new_id int,
	old_phone text,
	new_phone text,
	old_email text,
	new_email text,
	user_action text,
	created_at text
);

CREATE TRIGGER validate_email_before_insert_leads
	BEFORE INSERT ON leads
	BEGIN
		SELECT
			CASE
				WHEN NEW.email NOT LIKE '%_@__%.__%' THEN
				RAISE (ABORT,'Invalid email address')
			END;
	END

CREATE TRIGGER validate_phone
	BEFORE INSERT ON leads
	BEGIN
		SELECT
			CASE
				WHEN NEW.phone NOT LIKE '_________' THEN
				RAISE (ABORT,'Longitud del telefono erronea')
			END;
	END

CREATE TRIGGER validate_phone_numerico
	BEFORE INSERT ON leads
	BEGIN
		SELECT
			CASE
				WHEN NEW.phone IS NOT NUMERIC THEN
				RAISE (ABORT,'Longitud del telefono between')
			END;
	END
	
--Create trigger after ID
CREATE TRIGGER log_contact_after_update
	AFTER UPDATE ON leads
	WHEN old.phone <> new.phone
	OR old.email <> new.email
BEGIN
INSERT INTO lead_logs (
	old_id,
	new_id,
	old_phone,
	new_phone,
	old_email,
	new_email,
	user_action,
	created_at
)
VALUES
(
	old.id,
	new.id,
	old.phone,
	new.phone,
	old.email,
	new.email,
	'UPDATE',
	DATETIME('NOW')
) ;
END;

INSERT INTO leads (first_name,last_name,email,phone,source)
VALUES('Pepe','Pepito','pepe@pepito.pepecom','114567898','pepe');

UPDATE leads SET phone = '123456789' WHERE id = 2;

--------------------------------------------
CREATE TRIGGER log_contact_after_insert
	AFTER INSERT ON leads
	BEGIN
INSERT INTO lead_logs (
	old_id,
	new_id,
	old_phone,
	new_phone,
	old_email,
	new_email,
	user_action,
	created_at
)
VALUES
(
	" ",
	new.id,
	' ',
	new.phone,
	' ',
	new.email,
	'INSERT',
	DATETIME('NOW')
) ;
END;
INSERT INTO leads (first_name,last_name,email,phone,source)
VALUES('ROJAS','MARTINEZ','rojas@martinez.com','111111111','rojas');
-------------------------------------
CREATE TRIGGER log_contact_after_delete
	AFTER DELETE ON leads
	BEGIN
INSERT INTO lead_logs (
	old_id,
	new_id,
	old_phone,
	new_phone,
	old_email,
	new_email,
	user_action,
	created_at
)
VALUES
(
	old.id,
	'',
	old.phone,
	'',
	old.email,
	'',
	'DELETE',
	DATETIME('NOW')
) ;
END;

DELETE FROM leads WHERE id = 5;