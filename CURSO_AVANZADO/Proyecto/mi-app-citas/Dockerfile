# Etapa 1: Build de Angular con Node 16.20.2
FROM node:16.20.2 AS build
WORKDIR /app

# Copia los archivos del proyecto
COPY package*.json ./
RUN npm install

COPY . .
RUN npx ng build --configuration production --project mi-app-citas

# Etapa 2: NGINX para servir Angular
FROM nginx:stable-alpine
COPY --from=build /app/dist/mi-app-citas /usr/share/nginx/html

# Opcional: archivo personalizado para redirección SPA
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
