--ajouter  test class pour SalesFactTests,Dimcustomer....

-- Test pour vérifier que la colonne id n'a pas de valeurs NULL dans SalesFact
-- Exécuter tous les tests déjà présents
EXEC tSQLt.RunAll;
GO

-- Ajouter les classes de tests pour différentes tables
EXEC tSQLt.NewTestClass 'SalesFactTests';
GO

EXEC tSQLt.NewTestClass 'DimCustomerTest';
GO

EXEC tSQLt.NewTestClass 'DimDateTest';
GO

EXEC tSQLt.NewTestClass 'DimProductTest';
GO

EXEC tSQLt.NewTestClass 'DimShippingTest';
GO

EXEC tSQLt.NewTestClass 'DimSupplierTest';
GO

EXEC tSQLt.NewTestClass 'FactInventoryTest';
GO

-- Test pour vérifier que la colonne SaleID n'a pas de valeurs NULL dans SalesFact
CREATE PROCEDURE SalesFactTests.[test_no_null_SaleID_in_SalesFact]
AS
BEGIN

    -- Vérification de l'absence de valeurs NULL dans la colonne SaleID
    EXEC tSQLt.AssertEquals 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM ecommerv2.dbo.factSalles WHERE id IS NULL),
        @message = 'Test failed: SalesFact has NULL SaleID.';
END;
GO


-- Test pour vérifier que la colonne CustomerID n'a pas de valeurs NULL dans DimCustomer
CREATE PROCEDURE DimCustomerTest.[test_no_null_CustomerID_in_DimCustomer]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne CustomerID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM DimCustomer WHERE CustomerID IS NULL), 
        @message = 'Test failed: DimCustomer has NULL CustomerID.'
    );
END;
GO

-- Test pour vérifier que la colonne DateID n'a pas de valeurs NULL dans DimDate
CREATE PROCEDURE DimDateTest.[test_no_null_DateID_in_DimDate]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne DateID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM DimDate WHERE DateID IS NULL), 
        @message = 'Test failed: DimDate has NULL DateID.'
    );
END;
GO

-- Test pour vérifier que la colonne ProductID n'a pas de valeurs NULL dans DimProduct
CREATE PROCEDURE DimProductTest.[test_no_null_ProductID_in_DimProduct]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne ProductID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM DimProduct WHERE ProductID IS NULL), 
        @message = 'Test failed: DimProduct has NULL ProductID.'
    );
END;
GO

-- Test pour vérifier que la colonne ShippingID n'a pas de valeurs NULL dans DimShipping
CREATE PROCEDURE DimShippingTest.[test_no_null_ShippingID_in_DimShipping]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne ShippingID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM DimShipping WHERE ShippingID IS NULL), 
        @message = 'Test failed: DimShipping has NULL ShippingID.'
    );
END;
GO

-- Test pour vérifier que la colonne SupplierID n'a pas de valeurs NULL dans DimSupplier
CREATE PROCEDURE DimSupplierTest.[test_no_null_SupplierID_in_DimSupplier]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne SupplierID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM DimSupplier WHERE SupplierID IS NULL), 
        @message = 'Test failed: DimSupplier has NULL SupplierID.'
    );
END;
GO

-- Test pour vérifier que la colonne InventoryID n'a pas de valeurs NULL dans FactInventory
CREATE PROCEDURE FactInventoryTest.[test_no_null_InventoryID_in_FactInventory]
AS
BEGIN
    -- Vérification de l'absence de valeurs NULL dans la colonne InventoryID
    EXEC tSQLt.AssertEquals( 
        @expected = 0, 
        @actual = (SELECT COUNT(*) FROM FactInventory WHERE InventoryID IS NULL), 
        @message = 'Test failed: FactInventory has NULL InventoryID.'
    );
END;
GO

