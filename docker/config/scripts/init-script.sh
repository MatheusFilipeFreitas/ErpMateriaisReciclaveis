#!/bin/bash

# Iniciar o SQL Server
/opt/mssql/bin/sqlservr &

# Aguardar até que o SQL Server esteja pronto para aceitar conexões
/opt/mssql-tools/bin/sqlcmd -l 30 -S localhost -U SA -P laboratorio1@ -Q "SELECT 1" &> /dev/null
while [ $? -ne 0 ]; do
    echo "Aguardando SQL Server iniciar..."
    sleep 2
    /opt/mssql-tools/bin/sqlcmd -l 30 -S localhost -U SA -P laboratorio1@ -Q "SELECT 1" &> /dev/null
done

# Executar o arquivo .sh
./db_initial_config.sh

# Mantenha o script em execução
tail -f /dev/null