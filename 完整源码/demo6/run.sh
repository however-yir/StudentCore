#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT_DIR"

if [[ ! -f "config/db.properties" ]]; then
  echo "[INFO] config/db.properties not found. Creating from example..."
  cp config/db.properties.example config/db.properties
  echo "[WARN] Please edit config/db.properties before first login."
fi

mkdir -p out
find src -name "*.java" > .sources.list

echo "[INFO] Compiling StudentCore..."
javac -encoding UTF-8 -cp "lib/mysql-connector-java-8.0.11.jar" -d out @.sources.list

echo "[INFO] Launching login window..."
java -cp "out:lib/mysql-connector-java-8.0.11.jar" com.system.view.Login
