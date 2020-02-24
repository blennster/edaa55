function result = converge(c)
    z = c;
    i = 0;
    
    while abs(z) <= 2 && i < 100
        z = z * z + c;
        i = i + 1;
    end
    
    result = i;
end