compile:
	mill -i arithmetic.compile

bsp:
	mill -i mill.bsp.BSP/install

clean:
	git clean -fd

reformat:
	mill -i __.reformat

checkformat:
	mill -i __.checkFormat 

test:
	mill -i __.tests
