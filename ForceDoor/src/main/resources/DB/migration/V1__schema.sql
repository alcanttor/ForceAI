    create table action (
       id integer not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;
        
    create table available_rule (
       id integer not null,
        connector varchar(255),
        event varchar(255),
        name varchar(255),
        rule_expression varchar(255),
        default_email_template_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table available_rule_actions (
       available_rule_id integer not null,
        actions_id integer not null
    ) engine=InnoDB; 
    
    create table available_rule_fix_rules (
       available_rule_id integer not null,
        fix_rules_id integer not null
    ) engine=InnoDB;
    
    create table default_email_template (
       id integer not null,
        body varchar(255),
        name varchar(255),
        subject varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
    create table fix_rule (
       id integer not null,
        max varchar(255),
        min varchar(255),
        operation varchar(255),
        rule_type varchar(255),
        parameter_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB; 
    
    
    create table plan (
       id integer not null,
        description varchar(255),
        duration integer,
        name varchar(255),
        price double precision,
        rule_creation_allowed integer,
        rule_execution_allowed integer,
        site_sharing_allowed integer,
        units varchar(255),
        primary key (id)
    ) engine=InnoDB;
        
    create table rule (
       id integer not null,
        max varchar(255),
        min varchar(255),
        operation varchar(255),
        rule_type varchar(255),
        parameter_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table site (
       id integer not null,
        connector varchar(255),
        name varchar(255),
        site_token_id integer,
        user_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table site_rule (
       id integer not null,
        description varchar(255),
        event varchar(255),
        name varchar(255),
        rule_expression varchar(255),
        user_email_template_id integer,
        available_rule_id integer,
        site_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table site_rule_actions (
       site_rule_id integer not null,
        actions_id integer not null
    ) engine=InnoDB;
    
    create table site_rule_rules (
       site_rule_id integer not null,
        rules_id integer not null
    ) engine=InnoDB;
    
    create table site_token (
       id integer not null,
        expitred_on datetime(6),
        token varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
    create table system_parameters (
       id integer not null,
        data_type varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
    create table user (
       id integer not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
    
    create table user_email_template (
       id integer not null,
        body varchar(255),
        subject varchar(255),
        template_name varchar(255),
        available_rule_id integer,
        user_id integer,
        primary key (id)
    ) engine=InnoDB;
    
    create table user_subscription (
       id integer not null,
        end_date datetime(6),
        rule_creation_allowed integer,
        rule_creation_available integer,
        rule_creation_consumed integer,
        rule_execution_allowed integer,
        rule_execution_available integer,
        rule_execution_consumed integer,
        site_sharing_allowed integer,
        site_sharing_available integer,
        site_sharing_consumed integer,
        start_date datetime(6),
        subscription_status integer,
        plan_id integer,
        user_id integer,
        primary key (id)
    ) engine=InnoDB;
    

    alter table available_rule_fix_rules 
       add constraint UK_na5nkgaqxwfd38hdfq0tk8ke9 unique (fix_rules_id);
    
    
    alter table site_rule_actions 
       add constraint UK_2pod5qgkbe6lfe3ma8kth4qpq unique (actions_id); 
    
    alter table site_rule_rules 
       add constraint UK_gluqjxuy9328haaswpsjwrg5g unique (rules_id);
 
       
    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);
 
    
    alter table available_rule 
       add constraint FKg0i2n4nj1jesu59blhv90cykb 
       foreign key (default_email_template_id) 
       references default_email_template (id);
 
    
    alter table available_rule_actions 
       add constraint FK9wx4goh39vdds914v810v1nxu 
       foreign key (actions_id) 
       references action (id);
 
    
    alter table available_rule_actions 
       add constraint FK8pl7setm6do1vkj95yi2tgvee 
       foreign key (available_rule_id) 
       references available_rule (id);
 
    
    alter table available_rule_fix_rules 
       add constraint FK2dggbhgio4nemfoed1in78et5 
       foreign key (fix_rules_id) 
       references fix_rule (id);
 
    
    alter table available_rule_fix_rules 
       add constraint FK9iqylsi5hk2b2d7gw6g7khfgg 
       foreign key (available_rule_id) 
       references available_rule (id);
 
    
    alter table fix_rule 
       add constraint FKk8kljn21phpr0tn9xgr22a5tg 
       foreign key (parameter_id) 
       references system_parameters (id);
 
    
    alter table rule 
       add constraint FKjve12ighc9lukil41e7tvfqv1 
       foreign key (parameter_id) 
       references system_parameters (id);
 
    
    alter table site 
       add constraint FKpvavpf4ochnws00u1dlqplv1p 
       foreign key (site_token_id) 
       references site_token (id);
 
    
    alter table site 
       add constraint FK1jsyp7cbq68hqm2eb1qvmya8a 
       foreign key (user_id) 
       references user (id);
 
    
    alter table site_rule 
       add constraint FKgh7rc4e3ypjv9g50u5hmq9nfw 
       foreign key (user_email_template_id) 
       references user_email_template (id);
 
    
    alter table site_rule 
       add constraint FKnb40nmd6x6kji9umwpvfbbprb 
       foreign key (available_rule_id) 
       references available_rule (id);
 
    
    alter table site_rule 
       add constraint FK4j036ua014o21e2wf91has87o 
       foreign key (site_id) 
       references site (id);
 
    
    alter table site_rule_actions 
       add constraint FKq0623hu8vv9i3mo5a8vbc3f1v 
       foreign key (actions_id) 
       references action (id);
 
    
    alter table site_rule_actions 
       add constraint FKhrpsca38daej6x1a0bmmr4jc0 
       foreign key (site_rule_id) 
       references site_rule (id);
 
    
    alter table site_rule_rules 
       add constraint FKjn3o6d5cs2qosbpc4x737esi2 
       foreign key (rules_id) 
       references rule (id);
 
    
    alter table site_rule_rules 
       add constraint FKsbid855ws56xi6a6obvmahnjo 
       foreign key (site_rule_id) 
       references site_rule (id);
 
    
    alter table user_email_template 
       add constraint FKg8vv5stgpks9smhxh6vsn9pjc 
       foreign key (available_rule_id) 
       references available_rule (id);
 
    
    alter table user_email_template 
       add constraint FKcwwgjmt0ljn11faqhp3kp3vdt 
       foreign key (user_id) 
       references user (id);
 
    
    alter table user_subscription 
       add constraint FK195p3tjial094pcsmn5wk181q 
       foreign key (plan_id) 
       references plan (id);
 
    
    alter table user_subscription 
       add constraint FKpsiiu2nyr0cbxeluuouw474s9 
       foreign key (user_id) 
       references user (id);
       