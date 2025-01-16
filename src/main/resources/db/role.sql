CREATE TABLE users (
    id UUID PRIMARY KEY,                               -- UUID for the id
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    -- Date when the record was created
    updatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    -- Date when the record was last updated
    createdBy VARCHAR(255),                             -- User who created the record
    updatedBy VARCHAR(255),                             -- User who last updated the record
    role VARCHAR(255),                                  -- User's role (string)
    description TEXT                                    -- Description for the user
);