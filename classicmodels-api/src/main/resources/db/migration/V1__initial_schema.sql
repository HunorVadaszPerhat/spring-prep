CREATE TABLE IF NOT EXISTS offices (
    officeCode VARCHAR(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    territory VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS employees (
    employeeNumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    extension VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    officeCode VARCHAR(10) NOT NULL,
    reportsTo INT,
    jobTitle VARCHAR(50) NOT NULL,
    CONSTRAINT fk_employee_office FOREIGN KEY (officeCode) REFERENCES offices(officeCode),
    CONSTRAINT fk_employee_manager FOREIGN KEY (reportsTo) REFERENCES employees(employeeNumber)
);

CREATE TABLE IF NOT EXISTS customers (
    customerNumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50),
    postalCode VARCHAR(15),
    country VARCHAR(50) NOT NULL,
    salesRepEmployeeNumber INT,
    creditLimit DECIMAL(10,2),
    CONSTRAINT fk_customer_employee FOREIGN KEY (salesRepEmployeeNumber) REFERENCES employees(employeeNumber)
);

CREATE TABLE IF NOT EXISTS productlines (
    productLine VARCHAR(50) PRIMARY KEY,
    textDescription VARCHAR(4000),
    htmlDescription TEXT,
    image LONGBLOB
);

CREATE TABLE IF NOT EXISTS products (
    productCode VARCHAR(15) PRIMARY KEY,
    productName VARCHAR(70) NOT NULL,
    productLine VARCHAR(50) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock SMALLINT NOT NULL,
    buyPrice DECIMAL(10,2) NOT NULL,
    MSRP DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_products_productline FOREIGN KEY (productLine) REFERENCES productlines(productLine)
);

CREATE TABLE IF NOT EXISTS orders (
    orderNumber INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    customerNumber INT NOT NULL,
    CONSTRAINT fk_orders_customer FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber)
);

CREATE TABLE IF NOT EXISTS orderdetails (
    orderNumber INT NOT NULL,
    productCode VARCHAR(15) NOT NULL,
    quantityOrdered INT NOT NULL,
    priceEach DECIMAL(10,2) NOT NULL,
    orderLineNumber SMALLINT NOT NULL,
    PRIMARY KEY (orderNumber, productCode),
    CONSTRAINT fk_orderdetails_order FOREIGN KEY (orderNumber) REFERENCES orders(orderNumber),
    CONSTRAINT fk_orderdetails_product FOREIGN KEY (productCode) REFERENCES products(productCode)
);

CREATE TABLE IF NOT EXISTS payments (
    customerNumber INT NOT NULL,
    checkNumber VARCHAR(50) NOT NULL,
    paymentDate DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (customerNumber, checkNumber),
    CONSTRAINT fk_payments_customer FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber)
);
