/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kasun
 * Created: Jun 14, 2018
 */
DROP DATABASE bank_Management_System;

CREATE DATABASE bank_Management_System;

USE bank_Management_System;




CREATE TABLE accType(
	accTypeID VARCHAR(25) NOT NULL,
	accType VARCHAR (100) NOT NULL,
	rate DECIMAL (20,2) NOT NULL,
	minAmouOf1stDep DECIMAL (20,2) NOT NULL,
	CountOfOwners INTEGER (10) NOT NULL,
	CONSTRAINT PRIMARY KEY(accTypeID)
	
);

CREATE TABLE account(
	accNum VARCHAR(100) NOT NULL,
	openDate VARCHAR(50) NOT NULL,
	openTime VARCHAR(20) NOT NULL,
	total  DOUBLE (50,2) NOT NULL,
	accTypeID VARCHAR(25) NOT NULL,
	nic VARCHAR (20) NOT NULL,
	CONSTRAINT PRIMARY KEY(accNum),
	CONSTRAINT FOREIGN KEY (accTypeID) REFERENCES accType(accTypeID)
);

CREATE TABLE customer(
	cusID VARCHAR(50) NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	address VARCHAR(100) NOT NULL,
	ownerType VARCHAR(100) NOT NULL,
	dob VARCHAR(20) NOT NULL,
	nic VARCHAR(20) NOT NULL,
	gender VARCHAR(10) NOT NULL,
	Tell VARCHAR(20) NOT NULL,
	CONSTRAINT PRIMARY KEY(cusID)
);

CREATE TABLE cusAccDetails(
	cusAccDetailsID VARCHAR(50) NOT NULL,
	cusID VARCHAR(50) NOT NULL,
	accNum VARCHAR(100) NOT NULL,
	CONSTRAINT PRIMARY KEY(cusAccDetailsID),
	CONSTRAINT FOREIGN KEY (cusID) REFERENCES customer(cusID),
	CONSTRAINT FOREIGN KEY (accNum) REFERENCES account(accNum)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE transaction(
	tranId VARCHAR (50) NOT NULL,
	tranType VARCHAR (50) NOT NULL,
	accNum VARCHAR (100) NOT NULL,
	tranFee DECIMAL (50) NOT NULL,
	tranDate VARCHAR (50) NOT NULL,
	tranTime VARCHAR (20) NOT NULL,
	tranPersNIC VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY (tranId),
	CONSTRAINT FOREIGN KEY (accNum) REFERENCES account(accNum)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE loanType(
	loanTypeID VARCHAR(50) NOT NULL,
	loanType VARCHAR (100) NOT NULL,
	duration INTEGER (50) NOT NULL,
	rateCharge DECIMAL (20,2) NOT NULL,
	maxAmount DECIMAL (20,2) NOT NULL,
	minMonthSalary DECIMAL (20,2) NOT NULL,
	CONSTRAINT PRIMARY KEY(loanTypeID)
);

CREATE TABLE garenter(
	garenterID VARCHAR(50) NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	address VARCHAR(100) NOT NULL,
	nic VARCHAR(20) NOT NULL,
	dob VARCHAR(20) NOT NULL,
	mobNum VARCHAR(20) NOT NULL,
	homeTell VARCHAR(20) NOT NULL,
	gender VARCHAR(10) NOT NULL,
	job VARCHAR (50),
	monthSalary DECIMAL (50,2) NOT NULL,
	paysheetNum VARCHAR (100),
	CONSTRAINT PRIMARY KEY(garenterID)
);

CREATE TABLE loan(
	loanNum VARCHAR (50) NOT NULL,
	cusID VARCHAR(50) NOT NULL,
	loanAmount DECIMAL (50,2) NOT NULL,
	startDate VARCHAR (50) NOT NULL,
	firstGarenterID VARCHAR (50) NOT NUll,
	secondGarenterID VARCHAR (50) NOT NULL,
	loanTypeID VARCHAR (50) NOT NULL,
	duration INTEGER (50) NOT NULL,
	interestCharge DECIMAL (50,2) NOT NULL,
	monthlyPayment DECIMAL (50,2) NOT NULL,
	payDate VARCHAR (50) NOT NULL,
	total DECIMAL (50,2) NOT NULL,
	CONSTRAINT FOREIGN KEY (firstGarenterID) REFERENCES garenter(garenterID),
	CONSTRAINT FOREIGN KEY (secondGarenterID) REFERENCES garenter(garenterID),
	CONSTRAINT FOREIGN KEY (cusID) REFERENCES customer(cusID),
	CONSTRAINT FOREIGN KEY (loanTypeID) REFERENCES loanType(loanTypeID)
	ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE loanPlan(
	loanpID VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY (loanpID)
);
CREATE TABLE instalmentPayment(
	loanPayID VARCHAR (50) NOT NULL,
	loanNum VARCHAR (50) NOT NULL,
	payDate VARCHAR (50) NOT NULL,
	payPersNIC VARCHAR (50) NOT NULL,
	payAmount DECIMAL (50,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (loanPayID)
);

CREATE TABLE `user` (
  `userId` varchar(10) NOT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `saltValue` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

	


