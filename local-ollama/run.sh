docker run -d --name ollama   --gpus all   -p 11434:11434   -v ollama:/root/.ollama   ollama/ollama:latest

docker exec ollama ollama run deepseek-r1:8b

