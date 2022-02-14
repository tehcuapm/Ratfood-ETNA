FROM php:8.0.0-fpm
ENV TZ=Europe/Paris
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=composer /usr/bin/composer /usr/bin/composer
WORKDIR /var/www
CMD composer install ; composer update ; php-fpm 
RUN chown -R root:www-data .
RUN chmod 777 -R .
RUN groupadd -g 1000 www
RUN useradd -u 1000 -ms /bin/bash -g www www
USER www
EXPOSE 9000