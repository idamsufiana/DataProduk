CREATE TABLE product (
    id UUID PRIMARY KEY,                               -- UUID for the id
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    -- Date when the record was created
    updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    -- Date when the record was last updated
    createdBy VARCHAR(255),                             -- User who created the record
    updatedBy VARCHAR(255),                             -- User who last updated the record
    name VARCHAR(255) NOT NULL,                         -- Name of the product (cannot be null)
    description TEXT,                                   -- Description of the product
    stock INTEGER,                                      -- Stock quantity of the product
    price DOUBLE PRECISION                              -- Price of the product
);