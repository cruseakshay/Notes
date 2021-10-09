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

### Explore: django.contrib.auth, Django Forms: UserCreationForm
### {% csrf_token %}
### request.method == 'GET' same logic for other methods...
python manage.py makemigrations
python manage.py migrate

### Super user to check admin interface and DB.
python manage.py createsuperuser 

### IntegrityError for duplicate user handling it gracefully
### render() redirect() get_object_or_404

### For base template
{% if user.is_authenticated %}

Logged In as {{ user.username }}

    <a href="#">Logout</a>

{% else %}
    <a href="#">Sign Up</a>
    <a href="#">Login</a>
{% endif %}

{% block content %}{% endblock %}

### Models in Django to persist data, ForeignKey constraints
### Add models in admin.py, readonly field for admin interface
admin.site.register(<>)

### <int: pk> for mapping param e.g. /user/1
### href with path params for redirection.

### Page access only when authenticated.
from django.contrib.auth.decorators import login_required

### redirect to login when not authnticated. >>> settings.py
LOGIN_URL = 'path'








