#!/bin/bash

kill $(cat ./pids/eureka-server-pid.file) &
kill $(cat ./pids/api-gateway-pid.file) &
kill $(cat ./pids/customer-pid.file) &
kill $(cat ./pids/fraud-pid.file) &
kill $(cat ./pids/notification-pid.file) &

# cleanup
if [ -d "pids" ]; then
    echo "Cleanup 'pids' directory."
    rm -r "pids"
fi
