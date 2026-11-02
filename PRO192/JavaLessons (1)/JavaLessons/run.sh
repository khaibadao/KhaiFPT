#!/usr/bin/env bash
# Build và chạy không cần NetBeans/Maven (Linux / macOS / WSL)
#   ./run.sh        → menu
#   ./run.sh all    → chạy tất cả bài
#   ./run.sh 10     → chạy riêng bài 10
set -e
cd "$(dirname "$0")"
rm -rf out
javac -encoding UTF-8 -d out $(find src/main/java -name "*.java")
java -cp out Main "$@"
