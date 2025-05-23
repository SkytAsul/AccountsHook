# AccountsHook
![Maven Central Version](https://img.shields.io/maven-central/v/fr.skytasul/accountshook)

A simple, Vault-like plugin that allows other Spigot plugins to hook easily into existing accounts systems.

## Usage
```xml
		<dependency>
			<groupId>fr.skytasul</groupId>
			<artifactId>accountshook</artifactId>
			<version>{VERSION}</version>
			<scope>provided</scope>
		</dependency>
```

### Use existing accounts
```java
var accountsProvider = Bukkit.getServicesManager().load(AccountsProvider.class);
// do whatever you want
```
You can also listen to those events: `AccountJoinEvent` and `AccountLeaveEvent`.

### Create your own AccountsProvider
If you are creating your own MMO-like plugin that allows players to have multiple "classes", "accounts" or whatever you name them, you can create your own implementation of the AccountsProvider interface.

Once you have done that, you must register it using this code:
```java
Bukkit.getServicesManager().register(AccountsProvider.class, yourProviderInstance, yourPluginInstance, priority);
```
The priority should be highest than `ServicePriority.Lowest` since this is the one at which the default `UUIDAccountsProvider` is registered.
