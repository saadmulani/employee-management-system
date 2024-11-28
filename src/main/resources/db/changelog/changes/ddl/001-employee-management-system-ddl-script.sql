CREATE TABLE department (
                            id SERIAL PRIMARY KEY,
                            dept_name VARCHAR(255) NOT NULL,
                            location VARCHAR(255) NOT NULL
);

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          hire_date DATE NOT NULL,
                          salary NUMERIC(10, 2) NOT NULL,
                          department_id INTEGER NOT NULL,
                          CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE CASCADE
);