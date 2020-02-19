--insert status
INSERT INTO status (status)
VALUES ('Public'), ('Private'), ('Archived'), ('Blocked')
ON DUPLICATE KEY UPDATE
status=VALUES(status);
