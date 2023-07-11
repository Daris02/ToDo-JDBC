-- CREATE DATABASE todo_jdbc :

\c todo_jdbc;

CREATE TABLE "todo" (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    deadline TIMESTAMP CHECK (deadline > current_date),
    priority INT CHECK (priority <= 10 AND priority >= 0) DEFAULT 5,
    done BOOLEAN DEFAULT false
);