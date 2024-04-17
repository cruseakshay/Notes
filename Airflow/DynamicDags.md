# Dynamic Dags

Create a template file corresponding to your DAG structure with the different tasks. In it, for the inputs, you put some placeholders that the script will use to replace with the actual values.

Create a python script in charge of generating the DAGs by creating a file and replacing the placeholders in your template file with the actual values.

Put the script, somewhere else than in the folder DAGs.

Trigger this script either manually or with your CI/CD pipeline.


```python
from jinja2 import Environment, FileSystemLoader
import yaml
import os

file_dir = os.path.dirname(os.abs.path(f"{__file__/../}"))
env = Environment(loader=FileSystemLoader(file_dir))
template = env.get_template('templates/dag_template.jinja2')

for filename in os.listdir(f"{file_dir}/inputs"):
  print(filename)
  if filename.endswith('.yaml'):
    with open(f"{file_dir}/inputs/{filename}", "r") as input_file:
      inputs = yaml.safe_load(input_file)
      with open(f"dags/get_price_{inputs['dag_id']}.py", "w") as f: # depends on contents of yaml
        f.write(template.render(inputs))
```

The pros of this method:

It is Scalable as DAGs are not generated each time the folder dags/ is parsed by the Scheduler
Full visibility of the DAG code (one DAG -> one file)
Full control over the way DAGs are generated (script, less prone to errors or "zombie" DAGs)
