insert into User (id,Username, password) values(1,'varun','varun');
insert into User (id,Username, password) values(2,'charan','charan');

insert into plan (id,name,description,rule_creation_allowed,rule_execution_allowed,site_sharing_allowed) values(1,'Free','something free to test',10,10,1);
insert into plan (id,name,description,rule_creation_allowed,rule_execution_allowed,site_sharing_allowed) values(2,'Bronze','Single site',100,100,1);
insert into plan (id,name,description,rule_creation_allowed,rule_execution_allowed,site_sharing_allowed) values(3,'Silver','Multi Site Sharing',100,100,10);
insert into plan (id,name,description,rule_creation_allowed,rule_execution_allowed,site_sharing_allowed) values(4,'Gold','Super sharing and multi rules',1000,1000,100);

insert into action (id,name) values (1,'Email to User');
insert into action (id,name) values (2,'Email to Wish list User');
insert into action (id,name) values (3,'Email to Admin');


insert into system_parameters (id,name,data_type) values (1,'UserName','STRING');
insert into system_parameters (id,name,data_type) values (2,'DATETIME','DATETIME');
insert into system_parameters (id,name,data_type) values (3,'previousRole','STRING');
insert into system_parameters (id,name,data_type) values (4,'newRole','STRING');
insert into system_parameters (id,name,data_type) values (5,'roleUpdate','STRING');
insert into system_parameters (id,name,data_type) values (6,'UserProfileActivity','STRING');
insert into system_parameters (id,name,data_type) values (7,'paymentResult','STRING');
insert into system_parameters (id,name,data_type) values (8,'paymentId','STRING');
insert into system_parameters (id,name,data_type) values (9,'formName','STRING');
insert into system_parameters (id,name,data_type) values (10,'formResult','STRING');
insert into system_parameters (id,name,data_type) values (11,'oldPrice','DOUBLE');
insert into system_parameters (id,name,data_type) values (12,'newPrice','DOUBLE');
insert into system_parameters (id,name,data_type) values (13,'productName','STRING');
insert into system_parameters (id,name,data_type) values (14,'oldInventoryCount','DOUBLE');
insert into system_parameters (id,name,data_type) values (15,'newInventoryCount','DOUBLE');
insert into system_parameters (id,name,data_type) values (16,'priceUpdate','STRING');
insert into system_parameters (id,name,data_type) values (17,'inventoryUpdate','STRING');
insert into system_parameters (id,name,data_type) values (18,'UserType','STRING');
insert into system_parameters (id,name,data_type) values (19,'paymentAmount','DOUBLE');
insert into system_parameters (id,name,data_type) values (20,'revenuAmount','DOUBLE');
insert into system_parameters (id,name,data_type) values (21,'orderCount','DOUBLE');


insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(1,3,'EQUAL','admin',null,'STATIC');
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(2,4,'EQUAL','admin',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(3,5,'EQUAL','upGrade',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(4,5,'EQUAL','downGrade',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(5,6,'EQUAL','UserAdded',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(6,6,'EQUAL','Activated',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(7,6,'EQUAL','profileUpdate',null,'STATIC');
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(8,6,'EQUAL','UserNoteAdded',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(9,18,'EQUAL','admin',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(10,7,'EQUAL','success',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(11,7,'EQUAL','fail',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(12,10,'EQUAL','submit',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(13,6,'EQUAL','forgotPassword',null,'STATIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(14,16,'EQUAL','down',null,'STATIC');
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(15,15,'LESS_THAN',null,null,'DYNAMIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(16,21,'GREATER_THAN',null,null,'DYNAMIC'); 
insert into fix_rule (id,parameter_id,operation,min,max,rule_type) values(17,20,'GREATER_THAN',null,null,'DYNAMIC'); 

insert into default_email_template (id,name,subject,body) values(1,'Role Changed from Admin','Role Changed from Admin','Dear ${UserName}, Your role has been changed from ${previousRole} to ${newRole}. Thankyou.');


insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(1,'Role Changed from Admin','ROLE_CHANGE','1',1,'WORDPRESS');
insert into available_rule_actions(available_rule_id,actions_id) values(1,1);
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(1,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(2,'Role Changed to Admin','ROLE_CHANGE','2',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(2,2);
insert into available_rule_actions(available_rule_id,actions_id) values(2,1);


insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(3,'Role Upgrade','ROLE_CHANGE','3',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(3,3);
insert into available_rule_actions(available_rule_id,actions_id) values(3,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(4,'Role Down Grade','ROLE_CHANGE','4',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(4,4);
insert into available_rule_actions(available_rule_id,actions_id) values(4,1);


insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(5,'New User Added','USER_ACCOUNT_ACTIVITY','5',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(5,5);
insert into available_rule_actions(available_rule_id,actions_id) values(5,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(6,'New User Activated','USER_ACCOUNT_ACTIVITY','6',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(6,6);
insert into available_rule_actions(available_rule_id,actions_id) values(6,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(7,'User Modified Profile field','USER_ACCOUNT_ACTIVITY','7',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(7,7);
insert into available_rule_actions(available_rule_id,actions_id) values(7,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(8,'User Note Attached','USER_ACCOUNT_ACTIVITY','8&&9',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(8,8);
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(8,9);
insert into available_rule_actions(available_rule_id,actions_id) values(8,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(9,'Payment Complete','PAYMENT','10',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(9,10);
insert into available_rule_actions(available_rule_id,actions_id) values(9,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(10,'Payment Failed','PAYMENT','11',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(10,11);
insert into available_rule_actions(available_rule_id,actions_id) values(10,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(11,'Form Submitted','FORM_ACTION','12',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(11,12);
insert into available_rule_actions(available_rule_id,actions_id) values(11,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(12,'Password Recovered','USER_ACCOUNT_ACTIVITY','13',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(12,13);
insert into available_rule_actions(available_rule_id,actions_id) values(12,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(13,'Price reduction on Wishlisted Product','PRICE_UPDATE','14',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(13,14);
insert into available_rule_actions(available_rule_id,actions_id) values(13,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(14,'Wishlisted Product only x left','INVETORY_CHANGE','16',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(14,15);
insert into available_rule_actions(available_rule_id,actions_id) values(14,2);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(15,'Email Users above x purchase (revenue)','PAYMENT','17',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(15,17);
insert into available_rule_actions(available_rule_id,actions_id) values(15,1);

insert into available_rule (id,name,event,rule_expression,default_email_template_id,connector) values(16,'Email Users above x order count','PAYMENT','16',1,'WORDPRESS');
insert into available_rule_fix_rules (available_rule_id,fix_rules_id) values(16,16);
insert into available_rule_actions(available_rule_id,actions_id) values(16,1);


insert into site (id,connector,name,user_id) values (1,'WORDPRESS','ABC.com',1);
