CREATE OR REPLACE TRIGGER audit_ddl_changes
    AFTER CREATE OR DROP OR ALTER ON SCHEMA
BEGIN
    INSERT INTO dll_audit_log
    VALUES
        (SYSDATE
        ,sys_context('USERENV','SESSION_USER')
        ,sys_context('USERENV','OS_USER')
        ,sys_context('USERENV','HOST')
        ,sys_context('USERENV','TERMINAL')
        ,ora_sysevent
        ,ora_dict_obj_type
        ,ora_dict_obj_name);
END;
