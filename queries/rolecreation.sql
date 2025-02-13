USE ecommerv2;
GO

CREATE ROLE Administrateur;
CREATE ROLE Analyste;
GO
GRANT CONTROL ON DATABASE::ecommerv2 TO Administrateur;

GRANT CONNECT TO Analyste; 
GRANT SELECT ON SCHEMA::dbo TO Analyste; 
ALTER ROLE Administrateur ADD MEMBER user_admin;
ALTER ROLE Analyste ADD MEMBER user_analyst;
