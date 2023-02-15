### Frequently used commands for PIP.

#### To generate a list of all outdated packages:

pip list --outdated

#### PIP windows Upgrade (Powershell) 

pip freeze | %{$_.split('==')[0]} | %{pip install --upgrade $_}

#### Upgrade Packges from requirements.

pip install -r requirements.txt --upgrade

#### trusted host settings.
pip config set global.trusted-host "pypi.org files.pythonhosted.org pypi.python.org"
