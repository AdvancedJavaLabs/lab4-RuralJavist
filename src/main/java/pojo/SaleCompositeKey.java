package pojo;

import lombok.Getter;
import lombok.Setter;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Getter
@Setter
public class SaleCompositeKey implements Writable, WritableComparable<SaleCompositeKey> {

    private Long quantity;
    private Double revenue;

    public SaleCompositeKey(Long quantity, Double revenue) {
        this.quantity = quantity;
        this.revenue = revenue;
    }

    public SaleCompositeKey() {
        this.quantity = 0L;
        this.revenue = 0D;
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
    @Override
    public int compareTo(SaleCompositeKey o) {
        return Double.compare(this.revenue, o.revenue);
    }
}
