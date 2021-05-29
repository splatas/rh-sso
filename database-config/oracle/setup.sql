/* CREACION TABLA 'JGROUPSPING. */
CREATE TABLE JGROUPSPING (

   own_addr varchar(200) NOT NULL,

   bind_addr varchar(200) NOT NULL,

   created timestamp NOT NULL,

   cluster_name varchar(200) NOT NULL,

   ping_data blob,

   constraint PK_JGROUPSPING PRIMARY KEY (own_addr, cluster_name)

   );
   

/* VERIFICAR CONEXIONES ACTIVAS. */
select sysdate from dual;

/* VERIFICAR CONEXIONES ACTIVAS. */
SELECT ping_data FROM JGROUPSPING;
                       
    