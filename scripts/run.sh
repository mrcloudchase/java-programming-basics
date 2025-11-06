#!/usr/bin/env bash
# Usage: scripts/run.sh modules/01-hello-world HelloWorld
set -e
unit="$1"; main="$2"
mkdir -p out
javac -d out "$unit"/*.java
java -cp out "$main"
