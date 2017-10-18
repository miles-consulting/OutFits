
**Automated Scenarios for Outfittery**
- Edit Phone number
- Edit User address
- Edit Password

**How to run**
`mvn clean test -Dbrowser.type=firefox`


Note: After changing password invoke below API

**API URL** https://api.apps.outfittery.de/customers/736871752/passwords

**HTTP Method** PUT

**HTTPS Header**

`Content-Type:application/json

x-auth-token:8b442fc063ce4b03b061ed987608cad9

x-auth-uid:736871752`

 
