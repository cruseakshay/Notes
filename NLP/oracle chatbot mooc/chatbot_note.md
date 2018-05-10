# Description

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