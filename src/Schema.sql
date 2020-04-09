CREATE TABLE clients (
        id serial UNIQUE PRIMARY KEY,
        firstname VARCHAR(225),
        lastname VARCHAR(225),
        surname VARCHAR(225)
);
CREATE TABLE bankaccounts (
        id serial UNIQUE PRIMARY KEY,
        ownerid int NOT NULL,
        FOREIGN KEY (ownerid) REFERENCES clients(id),
        balance money NOT NULL,
        accountnumber VARCHAR(20)
);
CREATE TABLE transfers (
        id serial UNIQUE PRIMARY KEY,
        accountidfrom int NOT NULL ,
        accountidto int NOT NULL ,
        value money NOT NULL ,
        date DATE,
        FOREIGN KEY (accountidfrom) REFERENCES bankaccounts (id),
        FOREIGN KEY (accountidto) REFERENCES bankaccounts (id)
);
INSERT INTO clients (lastname,firstname,surname) VALUES
        ('Якомазкин', 'Павел', 'Сергеевич'),
        ('Геворкян','Ашот','Финикович'),
        ('Jhon','Smith','FromMatrix'),
        ('Распутин','Дмитрий','Медьведьевич'),
        ('Матвеев','Лесник','Забугорьевич'
);
INSERT INTO bankaccounts (ownerid, balance,accountnumber) VALUES
        (1, 777.00,'4276540031405789'),
        (1, 1000.00,'5476078900226190'),
        (2, 45234.00,'0984213475921111'),
        (3, 1753345.09,'2233445566778800'),
        (4, 153547.99,'0987654321098765'),
        (4, 99999.45,'4276323250507878'),
        (4, 10000000.00,'0000000000000000'),
        (5, -1.99,'4242757579791234'
);
INSERT INTO transfers (accountidfrom, accountidto, value, date) VALUES
        (1, 2, 199.00, '2020-01-20'),
        (1, 2, 20.00, '2020-01-19'),
        (5, 3, 8350.00, '2019-12-31'),
        (2, 4, 1.00, '2019-12-30'),
        (7, 5, 55.31, '2020-01-21'),
        (4, 6, 1000.01, '2019-11-01'),
        (3, 1, 666.00, '2019-06-06'),
        (5, 8, 19.75, '2020-01-20'),
        (7, 1, 33333.00, '2020-01-01'),
        (6, 4, 33.33, '2020-01-10'),
        (3, 7, 420.00, '2010-11-21'),
        (6, 2, 6742.17, '1999-03-13'
);
/*
Select
clientfrom.firstname as ИмяОтправителя,
value::numeric as СуммаПеревода,
clientto.firstname as ИмяПолучателя
from transfers as trans
inner join bankaccounts as bankaccfrom
on trans.accountidfrom = bankaccfrom.id
inner join clients as clientfrom
on bankaccfrom.ownerid=clientfrom.id
inner join bankaccounts as bankaccto
on trans.accountidto = bankaccto.id
inner join clients as clientto
on bankaccto.ownerid = clientto.id;
Запрос, для отображениятранзакций от кому к кому
*/