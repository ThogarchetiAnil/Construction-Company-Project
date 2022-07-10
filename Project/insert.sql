insert into construction_dept values('h1','satwik','9966021462'),
	('h2','asif','9963599303'),
	('h3','keertan','9390417577'),
	('h4','anil','8688065899');
	
insert into site_info values('s1',31.5,'hyderbad','532007','h1'),
	('s2',40,'vizag','532421','h2'),
	('s3',70,'chennai','600001','h3'),
	('s4',22,'mumbai','512215','h4'),
	('s5',65,'kochi','601106','h1'),
	('s6',50,'panaji','410014','h2');
	
insert into client values('c1','ramesh','anakapalli','9876543210','yes','verified','h1'),
	('c2','suresh','srikakulam','9874563210','no','verified','h2'),
	('c3','harish','kadapa','7896541230','yes','verified','h3'),
	('c4','girish','tirupathi','8795462130','no','Not verified','h4');
		
insert into houses values('hn1',5,6,'h1','c1','s1','2017/08/15'),
	('hn2',4,8,'h2','c2','s2','2015/07/06'),
	('hn3',3,5,'h3','c3','s3','2016/06/11'),
	('hn4',5,8,'h4','c4','s4','2017/05/12'),
	('hn5',1,2,'h1','c1','s5','2018/07/21'),
	('hn6',2,4,'h2','c2','s6','2019/09/30');
	
insert into retailer values('r1','mahesh','kollam','8558966974','h1'),
	('r2','muneendra','vijayawada','7845123690','h2'),
	('r3','kamal','visakhapatnam','8372914560','h3'),
	('r4','manish','karunagapalli','7456982310','h4');
	
insert into materials values('m1','nerolac','wood paint','2017model',6,10,5000,'h3'),
	('m2','asian paints','wall paint','2016model',7,11,6000,'h3'),
	('m3','berger','oil paint','2015model',8,12,11000,'h3'),
	('m4','ultra tech','cement','2014model',20,25,15000,'h1'),
	('m5','sharon','ply wood','2020model',15,20,21000,'h1'),
	('m6','SSS','brick','2013model',200,300,1000,'h4'),
	('m7','kajaria','tiles','2019model',400,600,3000,'h2');
	
insert into paints values('m1',11,'maroon'),
	('m2',7,'pink'),
	('m3',4,'white');
	
insert into hardware values('m5',32,'gurjan'),
	('m7',16,'A-grade');

insert into employee values('m1','hemanth',12000,7,10,'manager'),
	('m2','srikanth',13000,6,12,'manager'),
	('m3','rakesh',15000,5,9,'manager'),
	('s1','aneel',7000,4,7,'supervisior'),
	('s2','akash',6000,3,6,'supervisior'),
	('w1','amith',2000,1,2,'worker'),
	('w2','santosh',1000,1,2,'worker'),
	('w3','ameen',1500,1,2,'worker'),
	('w4','avinash',1200,1,1,'worker');
	
insert into manager values('m1',2,'hn1','3bhk'),
	('m2',2,'hn2','2bhk'),
	('m3',2,'hn3','doplex');
insert into supervisior values('s1',2),
	('s2',2);
insert into worker_names values('s1','amith'),
	('s1','santosh'),
	('s2','ameen'),
	('s2','avinash');
insert into worker values('w1',4,'hall room','painter'),
	('w2',5,'1st floor','labor'),
	('w3',6,'2nd floor','electritian'),
	('w4',7,'balcony','labor');

insert into constructs values('h1','c1','hn1',10,'m1'),
	('h2','c2','hn2',20,'m2'),
	('h3','c3','hn3',30,'m3'),
	('h4','c4','hn4',40,'m1'),
	('h1','c1','hn5',50,'m2'),
	('h2','c2','hn6',45,'m3');
	
insert into used_to_build values('m1','hn1'),
	('m4','hn1'),
	('m6','hn1'),
	('m2','hn2'),
	('m4','hn2'),
	('m6','hn2'),
	('m3','hn3'),
	('m4','hn3'),
	('m6','hn3'),
	('m4','hn4'),
	('m6','hn4'),
	('m4','hn5'),
	('m6','hn5'),
	('m5','hn5'),
	('m4','hn6'),
	('m6','hn6'),
	('m7','hn6');
	
insert into provides values('r3','m1'),
	('r3','m2'),
	('r3','m3'),
	('r1','m4'),
	('r1','m5'),
	('r4','m6'),
	('r2','m7');



