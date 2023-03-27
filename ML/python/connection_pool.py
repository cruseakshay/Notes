import pymssql
import pool

pool_params = {
   'max_connections': 10,
   'timeout': 30,
   'connection_params': {
      'server': 'your_server_name',
      'database': 'your_database_name',
      'user': 'your_username',
      'password': 'your_password'
   }
}

connection_pool = pool.Pool(pymssql, **pool_params)
with connection_pool.connection() as conn:
    with conn.cursor() as cursor:
        cursor.execute('SELECT * FROM your_table_name')
        rows = cursor.fetchall()
        for row in rows:
            print(row)

connection_pool.close()
