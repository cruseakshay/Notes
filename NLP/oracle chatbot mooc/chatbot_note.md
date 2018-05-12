# Description

[Refer this url for Docs](https://docs.oracle.com/en/cloud/paas/mobile-suite/develop/bots.html)

This course introduces you to the world of intelligent chatbots and how you can build them quickly and easily with Oracle Mobile Cloud, Enterprise.

-You will learn how to:
  -Develop a bot that understands natural human language using NLP (Natural Language Processing).
  -Enable your bot to use its intelligence as it interacts with users.
  -Integrate your bot with back end systems so that it can deliver enterprise data to users and execute tasks.
  -Introduce your bot to a potentially vast audience quickly and easily by integrating it with the Facebook Messenger platform.

## Week 1

After completing this week's lesson, you should be able to:

- Describe how chatbots can connect users to your enterprise data.
- Describe the building blocks of Oracle Intelligent Bots, how they enable chatbots to parse the user input, prompt users for more information, and reply to   users.
- Use the Bot Builder to:
  -Create intents
  -Add training data (utterances)
  -Define entities

### Terminology

- Intents (Unit of work that bot can perform, ususally mapped to business action)
- utterence (Sample phrases)
- entity (Custum entiites, day to day entities, built in entities )
  - Building custom entities
    - value list
    - derived (Imp. based on preceding or following phrase eg. from JFK to LDN)
    - entity list (eg. Depart_Airport > Location > [AirportCode, AirportName, City])
    - RegEx (eg. SR number, ticket number, order number etc.)
- artificial intelligence
- Conversational flow

also use of Custom components like REST serive calls to perform certain actions(backend services)

for week 1 - MasterBot_AS

## Week 2

After completing this week's lesson, you should be able to:

- Use the Bot Builder to create the bot-user conversation using our variant of YAML, OBotML.
- Learn about system components.
- Learn about custom components.
- Learn about the component service.
- Create a component service.
- Integrate the component service with OMCe.

- Dialogue flow in oracle chatbot
  - States
    - Component (System and Custom)
      - properties
      - actions
  - Action

- Conversation Flow markup
  - Header
  - Context (provides global variable scope for the bot eg. variableName:"variableType")
  - States (each individual state has one and only component- which does the work)
    - Component are like program functions and its properties like parameters
    - return statement to return from the or end of conversation (Transition options- 1. next: 2. error: etc..)

- System Components in dialogue flow:
  - out of box building blocks for building dialogue flow.
  - available components:
    - System.Output
    - System.SetVariable
    - System.Switch
    - Intent

- Custom Components in dialogue flow:
  - build by user
  - implemented as REST service
  - calls to backend (for fetching the desiered data)
  - Specialised UI

Custom components are reusable program units you build to add use case specific logic and backend system calls to a dialogue flow 


Oracle Mobile colud has REST Connector to interact with REST services.

Converter Shared API - for cross device compatibilty ??

- Each custom component exposes two functions
  - metadata (For discovery)
  - invoke (For execution)

Component service / Custom component service *accessed as REST services* (Custom API)
GET --> metadata (design time)
POST --> invoke (in dialogue flow)

Registry -- *simple file, component name and physical file location*

Shell -- *broker, routes the GET and POST*

SDK -- passed with custom compent and calls invoke method, gives access to input parameters [Refer](https://cloud.oracle.com/en_US/mobile/videos)

- Custom component setup and development [Refer](https://www.youtube.com/watch?time_continue=223&v=JcFf59sypfQ)
  - Download the starter app
  - Build component service 
  - Add SDK
  - Develop Component 
  - Depoly and register Component

-SDK [Refer](https://www.youtube.com/watch?time_continue=135&v=gEIeoWRfkSA)
  - functions to read from bot payload
    - text()
    - properties()
    - nlpResult()
    - request()
    - channelType()
    - variable(name, value) 
  - functions to write to the context
   - variable(name, value)
   - reply(JSON)
   - transition(value)
   - keepTurn(boolean)

- Backend Integration
  - mobile SDK
    - Developement steps
      - create conector
      - create shared API
      - configure shared API in component service
      - use shared API in Component