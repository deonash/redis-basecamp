#!/bin/bash

echo "🧹 Stopping and removing old containers (if any)..."
docker-compose down

echo "⏳ Waiting for Docker to release resources..."
sleep 5  # short delay, adjust to 5 if needed

echo "🚀 Starting MongoDB, Redis, and Mongo Express..."
docker-compose up -d

echo "✅ All containers are up!"
