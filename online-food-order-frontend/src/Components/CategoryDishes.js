import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import Base from './Base';
import { Table, Button } from 'reactstrap';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faCartPlus } from '@fortawesome/free-solid-svg-icons';

const CategoryDishes = () => {
    const [foodItems, setFoodItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const { categoryName } = useParams();

    useEffect(() => {
        const fetchFoodItems = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/foodItem/category/${categoryName}`);
                setFoodItems(response.data);
            } catch (error) {
                console.error("There was an error fetching the food items!", error);
            } finally {
                setLoading(false);
            }
        };

        fetchFoodItems();
    }, [categoryName]);

    if (loading) {
        return <div>Loading...</div>;
    }

    const handleAddToCart = (itemId) => {
        console.log(`Add item ${itemId} to cart`);
        // Implement add to cart functionality here
    };

    return (
        <Base>
            <div style={{ padding: '20px' }}>
                <h2>{categoryName} Dishes</h2>
                <Table striped>
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {foodItems.map(item => (
                            <tr key={item.id}>
                                <td>
                                    <img
                                        src={`http://localhost:8080/foodItem/food/image/${item.image}`} // URL pattern based on your backend
                                        alt={item.name}
                                        style={{
                                            width: '100px',
                                            height: '75px',
                                            objectFit: 'cover',
                                            borderRadius: '5px',
                                        }}
                                    />
                                </td>
                                <td>{item.name}</td>
                                <td>
                                    <Button
                                        color="primary"
                                        onClick={() => handleAddToCart(item.id)}
                                    >
                                        Add to Cart
                                    </Button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
            </div>
        </Base>
    );
};

export default CategoryDishes;
