#!/bin/bash
set -ex
npm install -g appium
appium -v
appium -a 127.0.0.1 -p 4723 &
