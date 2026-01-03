#!/bin/bash

certspath="puppetlabs/trapperkeeper-status/status-proxy-service-test/ssl"
if ! [[ -d "${certspath}" ]]; then
  echo "This script must be called from the dev-resources directory and ${certspath} must already exist"
  exit 1
fi

echo
echo "Generating primary self-signed CA"
openssl req -x509 \
  -newkey rsa:4096 \
  -keyout "${certspath}/ca.key" \
  -out "${certspath}/certs/ca.pem" \
  -days 1825 -nodes \
  -extensions x509v3_CA \
  -config exts.cnf \
  -subj "/C=US/ST=OR/L=Portland/O=Puppet, Inc/CN=puppet"

echo
echo "Generating node cert"
openssl genrsa -out "${certspath}/private_keys/localhost.pem" 2048

echo
echo "Creating node CSR"
openssl req -new -sha256 \
  -key "${certspath}/private_keys/localhost.pem" \
  -out "${certspath}/csr.pem" \
  -subj "/C=US/ST=OR/L=Portland/O=Puppet, Inc/CN=localhost"

echo
echo "Signing node CSR"
openssl x509 -req \
  -in "${certspath}/csr.pem" \
  -CA "${certspath}/certs/ca.pem" \
  -CAkey "${certspath}/ca.key" \
  -CAcreateserial \
  -out "${certspath}/certs/localhost.pem" \
  -days 1825 -sha256

echo
echo "Cleaning up files that will not be used by the tests"
rm "${certspath}"/{ca.key,csr.pem}
rm "${certspath}/certs/ca.srl"
