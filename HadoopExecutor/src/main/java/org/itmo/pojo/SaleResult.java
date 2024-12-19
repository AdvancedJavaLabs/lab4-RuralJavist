package org.itmo.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class SaleResult implements Writable {

    private Long quantity;
    private Double revenue;

    public SaleResult(Long quantity, Double revenue) {
        this.quantity = quantity;
        this.revenue = revenue;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(quantity);
        out.writeDouble(revenue);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        quantity = in.readLong();
        revenue = in.readDouble();
    }
}
