USE productdb;

START TRANSACTION;

INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes1', 'OGIS_Tokyo', 'sample data kubernetes1', 32978);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes2', 'OGIS_Tokyo', 'sample data kubernetes2', 37490);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes3', 'OGIS_Osaka', 'sample data kubernetes3', 5690);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes4', 'OGIS_Tokyo', 'sample data kubernetes4', 21978);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes5', 'OGIS_Osaka', 'sample data kubernetes5', 10259);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes6', 'OGIS_Osaka', 'sample data kubernetes6', 6237);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes7', 'OGIS_Osaka', 'sample data kubernetes7', 5920);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes8', 'OGIS_US', 'sample data kubernetes8', 6200);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes9', 'OGIS_CH', 'sample data kubernetes9', 7128);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes10', 'OGIS_US', 'sample data kubernetes10', 6245);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes11', 'OGIS_CH', 'sample data kubernetes11', 21345);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes12', 'OGIS_Tokyo', 'sample data kubernetes12', 7722);
INSERT INTO Product (name, maker, description, price) VALUES ('kubernetes13', 'OGIS_Tokyo', 'sample data kubernetes13', 3300);

COMMIT;