# SEPMDB-Decryptor
Java tools for decrypt SEPM (Symantec Endpoint Protection Manager) database connect password.

# Usage
## Build the source
```bash
javac SEPMDB_Decrypt.java
```

## Decrypt the database connection password
Extract the encrypted password start with `{V01}` from `C:\Program Files (x86)\Symantec\Symantec Endpoint Protection Manager\tomcat\conf\Catalina\localhost`
```bash
java SEPMDB_Decrypt.class {V01}XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
```