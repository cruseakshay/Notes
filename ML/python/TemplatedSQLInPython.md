# Templated SQL In Python 

Reference: https://medium.com/@sergei.izrailev

```python
user_transaction_template = '''
select
    user_id
    , count(*) as num_transactions
    , sum(amount) as total_amount
from
    transactions
where
    user_id = {{ user_id }}
    and transaction_date = {{ transaction_date }}
group by
    user_id
'''

params = {
    'user_id': 1234,
    'transaction_date': '2019-03-02',
}

from jinjasql import JinjaSql
j = JinjaSql(param_style='pyformat')
query, bind_params = j.prepare_query(user_transaction_template, params)

print(query)

print(bind_params)

import pandas as pd
frm = pd.read_sql(query, conn, params=bind_params)


from six import string_types

def quote_sql_string(value):
    '''
    If `value` is a string type, escapes single quotes in the string
    and returns the string enclosed in single quotes.
    '''
    if isinstance(value, string_types):
        new_value = str(value)
        new_value = new_value.replace("'", "''")
        return "'{}'".format(new_value)
    return value

from copy import deepcopy

def get_sql_from_template(query, bind_params):
    if not bind_params:
        return query
    params = deepcopy(bind_params)
    for key, val in params.items():
        params[key] = quote_sql_string(val)
    return query % params
    
from jinjasql import JinjaSql

def apply_sql_template(template, parameters):
    '''
    Apply a JinjaSql template (string) substituting parameters (dict) and return
    the final SQL.
    '''
    j = JinjaSql(param_style='pyformat')
    query, bind_params = j.prepare_query(template, parameters)
    return get_sql_from_template(query, bind_params)
```
