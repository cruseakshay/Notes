from sqlalchemy import create_engine

engine = create_engine('mssql+pymssql://user:password@server_name:1433/db_name')

from sqlalchemy import MetaData

metadata = MetaData()
metadata.reflect(bind=engine)
from sqlalchemy import Table

users_table = Table('users', metadata, autoload=True, autoload_with=engine)

with engine.connect() as conn:
    result = conn.execute(users_table.select())
    for row in result:
        print(row)
