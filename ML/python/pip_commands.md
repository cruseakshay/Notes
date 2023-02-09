### Frequently used commands for PIP.

#### To generate a list of all outdated packages:

pip list --outdated

#### PIP windows Upgrade

pip freeze | %{$_.split('==')[0]} | %{pip install --upgrade $_}
