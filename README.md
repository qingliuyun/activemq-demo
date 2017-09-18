# ActiveMQ使用demo

这是一个ActiveMQ入门demo。

## 说明

该demo中，包括一个生产者（Productor.java）和一个消费中（Customer.java）。根据自己的ActiveMQ的broker地址，修改两个类中的“brokerURL”静态变量。分别运行Customer和Productor两个类型。成功后，Customer控制台会输出“This is customer1  name=lili”文本。