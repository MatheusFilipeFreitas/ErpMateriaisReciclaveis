#!/bin/bash

# Função para executar arquivos SQL
execute_sql_file() {
    file=$1
    /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P laboratorio1@ -i "$file"
    return $?
}

# Array contendo os nomes dos arquivos SQL na ordem desejada de execução
sql_files=(
    "/docker-entrypoint-initdb.d/create_tables.sql"
    "/docker-entrypoint-initdb.d/insert_data.sql"
    "/docker-entrypoint-initdb.d/create_store_procedures.sql"
    "/docker-entrypoint-initdb.d/create_triggers.sql"
    "/docker-entrypoint-initdb.d/create_views.sql"
    # Adicione os arquivos SQL restantes aqui na ordem desejada
)

# Loop através dos arquivos SQL e executá-los sequencialmente
for file in "${sql_files[@]}"; do
    echo "Executando $file"
    execute_sql_file "$file"
    exit_status=$?
    
    # Verifica se houve algum erro na execução do arquivo SQL
    if [ $exit_status -ne 0 ]; then
        echo "Erro ao executar $file. Abortando a execução."
        exit $exit_status
    fi
done

echo "Todos os arquivos SQL foram executados com sucesso."
