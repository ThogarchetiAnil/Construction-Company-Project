create table construction_dept(head_id varchar(20) primary key,
							  	head_name varchar(30),
							  	phone_no varchar(10) check(length(phone_no)=10));
								
create table site_info(site_id varchar(20) primary key,
					   area_in_sqft float,
					   address varchar(50),
					   pincode varchar(6) check (length(pincode)=6),
					  head_id varchar(20) references construction_dept(head_id));
					  
create table client(c_id varchar(20) primary key,
				   	c_name varchar(30),
				   	address varchar(50),
				   	phone_no varchar(10) check(length(phone_no)=10),
					financial_support varchar(10),
					house_verification varchar(15),
				   	head_id varchar(20) references construction_dept(head_id));

create table houses(house_no varchar(10) primary key,
				   	no_of_floors int,
				   	no_of_rooms int,
				   	head_id varchar(20)references construction_dept(head_id),
				   	c_id varchar(20) references client(c_id),
				   	site_id varchar(20) references site_info(site_id),
					date_of_completion date);
					
create table retailer(r_id varchar(20) primary key,
					 	r_name varchar(30),
					 	address varchar(50),
					 	phone_no varchar(10) check(length(phone_no)=10),
					 	head_id varchar(20)references construction_dept(head_id));
						
create table materials(m_id varchar(20) primary key,
					  	m_name varchar(30),
					  	type varchar(20),
					  	model varchar(20),
					  	quantity int,
					  	reorder_lvl int check(reorder_lvl>=quantity),
					  	amount_req int,
					  	head_id varchar(20)references construction_dept(head_id));
						
create table paints(m_id varchar(20) references materials(m_id),
				   	weight float,
				   	color varchar(15),
				   	primary key(m_id));
				   
create table hardware(m_id varchar(20) references materials(m_id),
					 dimensions float,
					 quality varchar(10),
					 primary key(m_id));
create table employee(e_id varchar(20) primary key,
					  e_name varchar(20),
					  salary float,
					  workexp integer,
					  bonus float, 
					  profession varchar(50));
					  
create table manager(e_id varchar(20) references employee(e_id) primary key,
					 no_of_proj_assg integer,
					 current_proj varchar(20) references houses(house_no),
					 project_designs varchar(20));
					 
create table supervisior(e_id varchar(20) references employee(e_id) primary key,
						 no_of_workers integer);
						 
create table worker_names(e_id varchar(20) references employee(e_id),
						  w_name varchar(50));

create table worker(e_id varchar(20) references employee(e_id),
				   	work_hrs integer,
				    job_assigned varchar(20),
				    skills varchar(50));
	
create table constructs(head_id varchar(20)references construction_dept(head_id),
					   c_id varchar(20) references client(c_id),
					   house_no varchar(10) references houses(house_no),
						project_status float,
						e_id varchar(20) references employee(e_id),
					   primary key(head_id,c_id,house_no));

create table used_to_build(m_id varchar(20) references materials(m_id),
						  house_no varchar(10) references houses(house_no),
						  primary key(m_id,house_no));

create table provides(r_id varchar(20) references retailer(r_id),
					  m_id varchar(20) references materials(m_id),
					  primary key(m_id,r_id));
					  

								