FROM nginx:1.17.1-alpine
COPY --from=builder /app/dist/* /usr/share/nginx/html/
