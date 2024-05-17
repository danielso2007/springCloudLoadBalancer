#!/bin/bash
LOOP=$1

if [ -z "$1" ]; then
  # echo "Uso: $0 &lt;URL&gt;"
  # exit 1
  LOOP=10
fi

clear
echo "### Chamando API Hi ###"
for ((i = 1; i <= $LOOP; i++ ));
do
    echo "Request #$i:"
    curl http://localhost:8881/hi # -w "\n"
    echo ""  # Adiciona uma nova linha para separação
    # sleep 1
done

echo ""
echo ""
echo ""
echo "### Chamando API Hello ###"
for ((i = 1; i <= $LOOP; i++ ));
do
    echo "Request #$i:"
    curl http://localhost:8881/hello # -w "\n"
    echo ""  # Adiciona uma nova linha para separação
    # sleep 1
done
