# Use a imagem oficial do SQL Server
FROM mcr.microsoft.com/mssql/server:latest

# Copie o arquivo SQL para o container
COPY ./config/sql/create_tables.sql /docker-entrypoint-initdb.d/
COPY ./config//sql/insert_data.sql /docker-entrypoint-initdb.d/
COPY ./config//sql/create_store_procedures.sql /docker-entrypoint-initdb.d/
COPY ./config//sql/create_triggers.sql /docker-entrypoint-initdb.d/
COPY ./config//sql/create_views.sql /docker-entrypoint-initdb.d/

# Copie o script de inicialização personalizado
COPY ./config//scripts/init-script.sh /init-script.sh
COPY ./config//scripts/db_initial_config.sh /db_initial_config.sh

# Defina as variáveis de ambiente para o SQL Server
ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=laboratorio1@

# Configure o script de entrada personalizado
ENTRYPOINT ["/bin/bash", "/init-script.sh"]
