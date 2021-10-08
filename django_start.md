# Django reference

pip install django

django-admin startproject password_generator

### cd into project dir [password_generator]

python manage.py runserver

### manage.py >>> to runserver, create app etc...
### explore project structure of django project and app...

python manage.py startapp generator

### edit settings.py to add entry for the app

### edit urls.py to add path for / and imports app/views.py

### edit app/views.py to handle the request.

### create inside app dir: templates/appName/newfile.html

### how to render template html from views.py ?

### how to re-direct request to new url and reference the url in template html by it's name ?

### how to access request data ?
request.GET.get('')
