CREATE TABLE users (
    id UUID PRIMARY KEY,                                -- UUID for the id
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,     -- Date when the record was created
    updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,     -- Date when the record was last updated
    createdBy VARCHAR(255),                              -- User who created the record
    updatedBy VARCHAR(255),                              -- User who last updated the record
    userName VARCHAR(255) NOT NULL,                      -- User's username (cannot be null)
    password VARCHAR(255) NOT NULL,                      -- User's password (cannot be null)
    phone VARCHAR(20),                                   -- User's phone number (optional)
    email VARCHAR(255),                                  -- User's email address (optional)
    status BOOLEAN DEFAULT FALSE                         -- Status of the user (active/inactive)
);